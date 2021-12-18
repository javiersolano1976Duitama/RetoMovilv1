package co.com.cesardiaz.misiontic.mytask.model;

import java.util.ArrayList;
import java.util.List;

import co.com.cesardiaz.misiontic.mytask.mvp.MainMVP;
import co.com.cesardiaz.misiontic.mytask.view.dto.TaskItem;

public class MainInteractor implements MainMVP.Model {

    private List<TaskItem> tempItems;

    public MainInteractor() {

        tempItems = new ArrayList<>();
    }

    @Override
    public List<TaskItem> getTasks() {
        return tempItems;
    }
}
