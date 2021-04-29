package me.sfiguz7.transcendence.implementation.utils;

import me.sfiguz7.transcendence.TranscEndence;
import me.sfiguz7.transcendence.implementation.items.items.Daxi;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class SaveUtils {

    /*
     * Contains a couple methods to store and retrieve data upon restart
     * Hail the Blob for this kind code hand feeding (although modified to suit my needs)
     *
     * @author Walshy
     */

    private static final File path = TranscEndence.getInstance().getDataFolder();
    private static final File daxiEffectPlayersFile = new File(path, "daxiEffectPlayers.dat");
    private static final File toggledPlayersFile = new File(path, "toggledPlayers.dat");

    public static void writeData() {
        // Players and their Daxi effects Map
        try (final DataOutputStream dos = new DataOutputStream(new FileOutputStream(daxiEffectPlayersFile))) {
            final Map<UUID, Set<Daxi.Type>> daxiEffectPlayers = TranscEndence.getRegistry().getDaxiEffectPlayers();

            dos.writeInt(daxiEffectPlayers.size());

            for (Map.Entry<UUID, Set<Daxi.Type>> entry : daxiEffectPlayers.entrySet()) {
                dos.writeLong(entry.getKey().getMostSignificantBits());
                dos.writeLong(entry.getKey().getLeastSignificantBits());

                final Set<Daxi.Type> types = entry.getValue();
                dos.writeByte(types.size());
                for (Daxi.Type type : types) {
                    dos.writeByte(type.ordinal());
                }
            }

            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Toggled Players Set
        try (final DataOutputStream dos = new DataOutputStream(new FileOutputStream(toggledPlayersFile))) {
            final Set<UUID> toggledPlayers = TranscEndence.getRegistry().getToggledPlayers();

            dos.writeInt(toggledPlayers.size());

            for (UUID uuid : toggledPlayers) {
                dos.writeLong(uuid.getMostSignificantBits());
                dos.writeLong(uuid.getLeastSignificantBits());
            }

            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readData() {
        if (daxiEffectPlayersFile.exists()) {
            // Players and their Daxi effects Map
            try (final DataInputStream dis = new DataInputStream(new FileInputStream(daxiEffectPlayersFile))) {
                Map<UUID, Set<Daxi.Type>> daxiEffectPlayers = TranscEndence.getRegistry().getDaxiEffectPlayers();

                final int size = dis.readInt();
                for (int i = 0; i < size; i++) {
                    // Construct the UUID from the least and most sig bits.
                    final UUID uuid = new UUID(dis.readLong(), dis.readLong());

                    // Amount of enums this user has
                    final int len = dis.readByte();
                    final Set<Daxi.Type> types = new HashSet<>();
                    for (int typeI = 0; typeI < len; typeI++) {
                        types.add(Daxi.Type.values[dis.readByte()]);
                    }

                    daxiEffectPlayers.put(uuid, types);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Toggled Players Set
        if (toggledPlayersFile.exists()) {
            try (final DataInputStream dis = new DataInputStream(new FileInputStream(toggledPlayersFile))) {
                Set<UUID> toggledPlayers = TranscEndence.getRegistry().getToggledPlayers();

                final int size = dis.readInt();
                for (int i = 0; i < size; i++) {
                    // Construct the UUID from the least and most sig bits.
                    toggledPlayers.add(new UUID(dis.readLong(), dis.readLong()));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
