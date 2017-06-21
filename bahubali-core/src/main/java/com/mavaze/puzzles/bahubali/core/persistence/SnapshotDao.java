package com.mavaze.puzzles.bahubali.core.persistence;

import java.io.File;
import java.io.IOException;

import com.mavaze.puzzles.bahubali.core.domain.GameSnapshot;

public interface SnapshotDao {

	String save(GameSnapshot snapshot) throws Exception;

	GameSnapshot load(File file) throws ClassNotFoundException, IOException;

}
