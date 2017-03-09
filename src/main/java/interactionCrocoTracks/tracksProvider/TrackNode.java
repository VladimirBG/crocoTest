package interactionCrocoTracks.tracksProvider;

/**
 * Json конфигурация может содержать несколько данных по трекам, которые описывает этот класс.
 */
public class TrackNode {

    private int employeeId;
    private long taskId;
    private String comment;
    private long start;
    private long end;
    private int priority = 0;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return employeeId + " "  + taskId + " " + comment  + " " + start + end;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
