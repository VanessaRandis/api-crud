package com.aula.projeto.task;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/tarefa")
public class TaskController {

    @Autowired
    private ITaskRepository taskRepository;

    @PostMapping("/nova")
    public TaskModel novaTarefa(@RequestBody TaskModel taskModel) {
        var tarefaNova = this.taskRepository.save(taskModel);
        return tarefaNova;
    }
    



    
}
