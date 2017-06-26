package com.mavaze.puzzles.bahubali.core.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.mavaze.puzzles.bahubali.core.domain.GameSnapshot;

public class SerializedSnapshotDao implements SnapshotDao {

	@Override
	public String save(final GameSnapshot snapshot) throws IOException {
		String identifier = snapshot.getMenuName();
		try (FileOutputStream fout = new FileOutputStream(
				new File("snapshots", identifier + ".snapshot"));
				ObjectOutputStream oos = new ObjectOutputStream(fout)) {
			oos.writeObject(snapshot);
		}
		return identifier;
	}

	@Override
	public GameSnapshot load(final File file) throws IOException  {		
		try (FileInputStream fin = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fin)) {
			return (GameSnapshot) ois.readObject();
		} catch (ClassNotFoundException | IOException e) {
			throw new IOException(e);
		}
	}

}