package co.com.cesardiaz.misiontic.mytask.mvp;

import java.util.List;

import co.com.cesardiaz.misiontic.mytask.view.dto.TaskItem;

public interface MainMVP {


    interface Model {
        default List<TaskItem> getTasks() {
            return null;
        }
        void saveTask(TaskItem task);
    }

    interface Presenter {
        void loadTasks();
        void addNewTask();
    }

    interface View {
        void showTaskList(List<TaskItem> items);

        String getTaskDescription();

        void addTaskToList(TaskItem task);
    }
}
