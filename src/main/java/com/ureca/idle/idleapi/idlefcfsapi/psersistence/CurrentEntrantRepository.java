package com.ureca.idle.idleapi.idlefcfsapi.psersistence;



public interface CurrentEntrantRepository {

    Boolean isAlreadyEntered(Long userId);
    void addEntrant(Long userId);
}
