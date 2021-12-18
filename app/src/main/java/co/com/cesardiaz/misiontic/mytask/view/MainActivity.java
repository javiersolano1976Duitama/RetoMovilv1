package co.com.cesardiaz.misiontic.mytask.view;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import co.com.cesardiaz.misiontic.mytask.R;
import co.com.cesardiaz.misiontic.mytask.mvp.MainMVP;
import co.com.cesardiaz.misiontic.mytask.presenter.MainPresenter;
import co.com.cesardiaz.misiontic.mytask.view.adapter.TaskAdapter;
import co.com.cesardiaz.misiontic.mytask.view.dto.TaskItem;


public class MainActivity extends AppCompatActivity implements MainMVP.View {

    private TextInputLayout tilNewTask;
    private TextInputEditText etNewTask;
    private RecyclerView rvTasks;

    private TaskAdapter taskAdapter;

    private MainMVP.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenter(MainActivity.this);
        initUI(); // método inferior
        presenter.loadTasks();
    }

    private void initUI() {
        tilNewTask = findViewById(R.id.til_new_task);
        tilNewTask.setEndIconOnClickListener(v -> presenter.addNewTask());
        etNewTask = findViewById(R.id.et_new_task);
        taskAdapter = new TaskAdapter();
        rvTasks = findViewById(R.id.rv_tasks);
        rvTasks.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rvTasks.setAdapter(taskAdapter);
    }

    @Override
    public void showTaskList(List<TaskItem> items) {
        taskAdapter.setData(items);
    }

    @Override
    public String getTaskDescription() {
        return etNewTask.getText().toString();
    }

    @Override
    public void addTaskToList(TaskItem task) {
        taskAdapter.addItem(task);
    }
}

