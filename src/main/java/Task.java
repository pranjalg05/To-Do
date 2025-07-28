class Task{

    private int ID;
    private String task;
    private boolean completed;

    public Task(int ID, String task, boolean completed) {
        this.completed = completed;
        this.task = task;
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public String getTask() {
        return task;
    }

    public boolean isCompleted() {
        return completed;
    }

    public Task setCompleted(boolean completed) {
        this.completed = completed;
        return this;
    }
}
