package com.mavaze.puzzles.bahubali.core.persistence;

import com.mavaze.puzzles.bahubali.core.domain.Snapshot;

public interface SnapshotDao {

	String save(Snapshot snapshot) throws Exception;

	Snapshot load(String identifier) throws Exception;

}
