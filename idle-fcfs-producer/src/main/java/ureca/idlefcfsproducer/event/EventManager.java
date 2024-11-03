package ureca.idlefcfsproducer.event;

public interface EventManager {

    void checkEventEnd();
    void checkDuplicatedSubmission(Submission submission);
    void registerToDuplicatedSubmission(Submission submission);
}
