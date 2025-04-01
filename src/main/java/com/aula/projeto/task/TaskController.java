package com.aula.projeto.task;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;


@RestController
@RequestMapping("/tarefa")
public class TaskController {

    @Autowired
    private ITaskRepository taskRepository;

    @PostMapping("/nova")
    public TaskModel novaTarefa(@RequestBody TaskModel taskModel, HttpServletRequest request ) {

        var idUser = request.getAttribute("idUser");// coloca em uma variavel o valor setado do idUser que esta no cursoModel
        taskModel.setIdUser((UUID) idUser); // aqui faz um casting para que o dado seja UUID

        var tarefaNova = this.taskRepository.save(taskModel);
        return tarefaNova;
    }

}
