package fact.it.tab_service.service;

import fact.it.tab_service.model.Tab;
import fact.it.tab_service.repository.TabRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TabService {

    private final TabRepository tabRepository;

    public TabService(TabRepository tabRepository) {
        this.tabRepository = tabRepository;
    }

    public List<Tab> getAllTabs() {
        return tabRepository.findAll();
    }

    public Optional<Tab> getTabById(Long id) {
        return tabRepository.findById(id);
    }

    public Tab createTab(Tab tab) {
        return tabRepository.save(tab);
    }

    public Tab updateTab(Long id, Tab updatedTab) {
        return tabRepository.findById(id)
                .map(existingTab -> {
                    existingTab.setName(updatedTab.getName());
                    existingTab.setQuantity(updatedTab.getQuantity());
                    return tabRepository.save(existingTab);
                })
                .orElseThrow(() -> new RuntimeException("Tab not found with id " + id));
    }

    public void deleteTab(Long id) {
        tabRepository.deleteById(id);
    }
}
