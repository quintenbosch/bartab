package fact.it.tab_service.controller;

import fact.it.tab_service.model.Tab;
import fact.it.tab_service.service.TabService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tabs")
public class TabController {

    private final TabService tabService;

    public TabController(TabService tabService) {
        this.tabService = tabService;
    }

    @GetMapping
    public List<Tab> getAllTabs() {
        return tabService.getAllTabs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tab> getTabById(@PathVariable Long id) {
        return tabService.getTabById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Tab createTab(@RequestBody Tab tab) {
        return tabService.createTab(tab);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tab> updateTab(@PathVariable Long id, @RequestBody Tab tab) {
        try {
            return ResponseEntity.ok(tabService.updateTab(id, tab));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTab(@PathVariable Long id) {
        tabService.deleteTab(id);
        return ResponseEntity.noContent().build();
    }
}
