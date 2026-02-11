package org.dockerpractice.dockerpractice.service;

import lombok.RequiredArgsConstructor;
import org.dockerpractice.dockerpractice.CheckRepository;
import org.dockerpractice.dockerpractice.entity.MemoEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckServiceImpl implements CheckService {

    private final CheckRepository checkRepository;

    @Override
    public void checkSave() {
        checkRepository.save(new MemoEntity("테스트"));
    }
}
