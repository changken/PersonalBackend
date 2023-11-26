package org.changken.personalspring.repository;

import org.changken.personalspring.pojo.Memo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemoRepository extends CrudRepository<Memo, Long> {
}
