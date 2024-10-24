package com.ureca.idle.idleapi.idlefcfsapi.psersistence;


public interface SubmissionQueue {

    void pollSubmission();
    void offerSubmission();
}
