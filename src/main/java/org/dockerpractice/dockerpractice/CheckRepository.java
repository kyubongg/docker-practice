package org.dockerpractice.dockerpractice;

import org.dockerpractice.dockerpractice.entity.MemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckRepository extends JpaRepository<MemoEntity, Long> {

}
