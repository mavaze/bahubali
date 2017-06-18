package com.mavaze.puzzles.bahubali.core.persistence;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.mavaze.puzzles.bahubali.core.domain.Snapshot;

public class SerializedSnapshotDao implements SnapshotDao {

	@Override
	public String save(final Snapshot snapshot) throws IOException {
		String identifier = null;
		try (FileOutputStream fout = new FileOutputStream(identifier + ".snapshot");
				ObjectOutputStream oos = new ObjectOutputStream(fout)) {
			oos.writeObject(snapshot);
		}
		return identifier;
	}

	@Override
	public Snapshot load(final String identifier) throws ClassNotFoundException, IOException {
		try (FileInputStream fin = new FileInputStream(identifier + ".snapshot");
				ObjectInputStream ois = new ObjectInputStream(fin)) {
			return (Snapshot) ois.readObject();
		}
	}

}