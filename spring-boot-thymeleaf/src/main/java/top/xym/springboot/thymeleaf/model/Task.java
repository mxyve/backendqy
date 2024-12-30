package top.xym.springboot.thymeleaf.model;

public class Task {
    private Long id;
    private String description;
    private boolean completed;

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public boolean isCompleted() {
        return completed;
    }
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Task(Long id, String description) {
        this.id = id;
        this.description = description;
        // 默认未完成
        this.completed = false;
    }


}
