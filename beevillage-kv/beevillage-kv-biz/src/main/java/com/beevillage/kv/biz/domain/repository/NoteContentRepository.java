package com.beevillage.kv.biz.domain.repository;

import com.beevillage.kv.biz.domain.dataobject.NoteContentDO;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

/**
 *
 * @author Jason Feng
 * @since 2026-03-01 11:11
 */
public interface NoteContentRepository extends CassandraRepository<NoteContentDO, UUID> {

}