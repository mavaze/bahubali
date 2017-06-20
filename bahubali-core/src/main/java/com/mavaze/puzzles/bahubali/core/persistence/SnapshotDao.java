package com.mavaze.puzzles.bahubali.core.persistence;

import java.io.File;
import java.io.IOException;

import com.mavaze.puzzles.bahubali.core.domain.Snapshot;

public interface SnapshotDao {

	String save(Snapshot snapshot) throws Exception;

	Snapshot load(File file) throws ClassNotFoundException, IOException;

}
