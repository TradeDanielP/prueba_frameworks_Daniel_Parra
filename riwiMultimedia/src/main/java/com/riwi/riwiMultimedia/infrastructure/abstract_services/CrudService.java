package com.riwi.riwiMultimedia.infrastructure.abstract_services;

import org.springframework.data.domain.Page;

public interface CrudService<RQ, RS, ID> {
    
    public RS create(RQ request);

    public RS get(ID id);

    public RS update(RQ request, ID id);

    public RS disable(ID id);

    public Page<RS> getAll(int page, int size);

}
