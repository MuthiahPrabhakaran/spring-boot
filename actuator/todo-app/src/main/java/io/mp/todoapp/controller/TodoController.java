package io.mp.todoapp.controller;

import io.mp.todoapp.service.TodoService;
import io.mp.todoapp.dto.TodoListDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private TodoService todoService;

    @Inject
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/lists")
    public List<TodoListDto> getTodoLists() {
        return todoService.getTodoLists();
    }
}
