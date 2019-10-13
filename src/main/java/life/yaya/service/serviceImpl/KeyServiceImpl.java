package life.yaya.service.serviceImpl;

import life.yaya.dao.KeyDao;
import life.yaya.service.KeyService;

public class KeyServiceImpl implements KeyService {
    private KeyDao keyDao;
    @Override
    public boolean verifyKey(String key) {
        return false;

    }
}
