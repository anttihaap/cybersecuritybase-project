package sec.project.config;

import org.apache.catalina.session.StandardManager;

public class SimpleSessionManager extends StandardManager {
    
    private int sessionId = 1;

    @Override
    protected String generateSessionId() {
        return "" + ++sessionId;
    }

}
