package life.yaya.service.impl;

import life.yaya.dao.KeyDao;
import life.yaya.service.KeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("KeyService")
public class KeyServiceImpl implements KeyService {
    @Autowired
    private KeyDao keyDao;
    @Override
    public boolean verifyKey(String key) {
        return false;

    }
}
