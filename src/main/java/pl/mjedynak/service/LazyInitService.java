package pl.mjedynak.service;

import java.time.LocalDateTime;

public class LazyInitService implements Service {
    private Service service;

    @Override
    public LocalDateTime getTime() {
        initializeIfNecessary();
        return service.getTime();
    }

    private void initializeIfNecessary() {
        if (service == null) {
            service = new DefaultService();
        }
    }
}
