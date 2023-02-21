package com.example.hibernate_lab_4.controller;

import com.example.hibernate_lab_4.entity.Property;
import com.example.hibernate_lab_4.entity.Tenant;
import com.example.hibernate_lab_4.entity.User;
import com.example.hibernate_lab_4.entity.Worker;
import com.example.hibernate_lab_4.service.UserService;
import com.example.hibernate_lab_4.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/allWorkers")
public class WorkersController {
    @Autowired
    WorkerService workerService;
    @Autowired
    UserService userService;

    @GetMapping("")
    public String showMainPage(Model model) {
        List<Worker> workers = workerService.getAllWorkers();

        model.addAttribute("allWorkers", workers);

        return "worker/all-workers";
    }

    @GetMapping("/worker")
    public String showWorkersForWorker(Model model) {
        List<Worker> workers = workerService.getAllWorkers();

        model.addAttribute("allWorkers", workers);

        return "workerAndTenantPages/all-workers";
    }

    @GetMapping("/addWorker")
    public String addTenant(Model model) {
        model.addAttribute("allUsers", userService.getNullWorkerUsers());

        return "worker/add-worker";
    }

    @PostMapping("/addWorker")
    public String addTenant(@RequestParam String name, @RequestParam String surname,
                            @RequestParam String phone, @RequestParam String specialization, @RequestParam String userLogin) {

        User user = userService.getUserByLogin(userLogin);
        Worker worker = new Worker(name, surname, phone, specialization, user);

        workerService.saveWorker(worker);

        return "redirect:/allWorkers";
    }

    @GetMapping("/{id}/edit")
    public String editWorker(@PathVariable(value = "id") Integer id, Model model) {
        if (workerService.getWorker(id) == null) {
            return "redirect:/allWorkers";
        }
        model.addAttribute("worker", workerService.getWorker(id));

        return "worker/worker-edit";
    }

    @PostMapping("/{id}/edit")
    public String editWorker(@PathVariable(value = "id") Integer id, @RequestParam String name,
                             @RequestParam String surname, @RequestParam String phone,
                             @RequestParam String specialization) {

        Worker worker = workerService.getWorker(id);

        worker.setName(name);
        worker.setSurname(surname);
        worker.setPhone(phone);
        worker.setSpecialization(specialization);
        workerService.saveWorker(worker);

        return "redirect:/allWorkers";
    }

    @PostMapping("/{id}/remove")
    public String deleteWorker(@PathVariable(value = "id") Integer id) {
        workerService.deleteWorker(id);

        return "redirect:/allWorkers";
    }
}