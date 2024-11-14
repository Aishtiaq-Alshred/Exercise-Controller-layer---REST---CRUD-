package com.example.exercisecontrollerlayer.Controllerlayer;

import com.example.exercisecontrollerlayer.ApiResponse.ApiResponse;
import com.example.exercisecontrollerlayer.TaskTrackerSystem.Tasktrackersystem;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/Controllerlayer")

public class Controllerlayer {

    ArrayList<Tasktrackersystem> tasks = new ArrayList<>();


    @GetMapping("/get")
    public ArrayList<Tasktrackersystem> getTasks() {
        return tasks;
    }


    @PostMapping("/add")
    public ApiResponse addTasks(@RequestBody Tasktrackersystem task) {
        task.setStatus("not done");
        tasks.add(task);
        return new ApiResponse("Task added");
    }




    @PutMapping("/update/{index}")
    public ApiResponse updateTasks(@PathVariable int index, @RequestBody Tasktrackersystem task) {
        tasks.set(index, task);
        return new ApiResponse("Task update");
    }


    @DeleteMapping("/delete/{index}")
    public ApiResponse delete(@PathVariable int index) {
        tasks.remove(index);
        return new ApiResponse("Task delete");
    }





    @PutMapping("/change/{index}")
    public ApiResponse changeStauts(@PathVariable int index) {
        Tasktrackersystem task = tasks.get(index);

        if (task.getStatus().equals("not done")) {
            task.setStatus(" done");
            tasks.set(index, task);
            return new ApiResponse("Task  found ");
        } else {
            task.setStatus("done");
            tasks.set(index, task);
            return new ApiResponse("Task  found ");

        }
    }


    @GetMapping("/search/{titles}")
    public ApiResponse searchTask(@PathVariable String titles) {

        for (Tasktrackersystem search : tasks) {
            if (search.getTitle().equals(titles)) {
                return new ApiResponse(" Task  found  " + search);
            }
        }
        return new ApiResponse(" Task not found ");
    }

    }





