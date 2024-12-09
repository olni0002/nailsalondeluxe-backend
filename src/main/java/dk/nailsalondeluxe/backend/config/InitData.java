package dk.nailsalondeluxe.backend.config;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dk.nailsalondeluxe.backend.model.Category;
import dk.nailsalondeluxe.backend.model.Treatment;
import dk.nailsalondeluxe.backend.repository.CategoryRepository;
import dk.nailsalondeluxe.backend.repository.TreatmentRepository;

@Component
public class InitData implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private TreatmentRepository treatmentRepository;

    public InitData(CategoryRepository categoryRepository, TreatmentRepository treatmentRepository) {
        this.categoryRepository = categoryRepository;
        this.treatmentRepository = treatmentRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Category[] categories = addCategories();
        addTreatments(categories);
    }
    
    private Category[] addCategories() {

        Category[] categories = new Category[12];

        for (int i = 0; i < categories.length; i++) {
            categories[i] = new Category();
        }

        categories[0].setName("KUNSTIGE NEGLE");
        categories[1].setName("PÅFYLDNING");
        categories[2].setName("GELE NEGLE");
        categories[3].setName("PÅFYLDNING");
        categories[4].setName("REPARATION");
        categories[5].setName("VOKSBEHANDLING");
        categories[6].setName("DIPPING POWDER NEGLE");
        categories[7].setName("PÅFYLDNING");
        categories[8].setName("MANICURE & PEDICURE");
        categories[9].setName("DESIGN");
        categories[10].setName("EYELASHES");
        categories[11].setName("DIVERSE");

        categoryRepository.saveAll(Arrays.asList(categories));
        return categories;
    }

    private void addTreatments(Category[] categories) {

        Treatment[] treatments = new Treatment[59];
        int i = 0;

        for (int j = 0; j < treatments.length; j++) {
            treatments[j] = new Treatment();
        }

        treatments[0].setName("Akryl naturlig sæt");
        treatments[0].setPrice(395);

        treatments[1].setName("Akryl pink og hvid sæt");
        treatments[1].setPrice(495);

        treatments[2].setName("Akryl med gellak sæt");
        treatments[2].setPrice(495);
        
        treatments[3].setName("Akryl med glitter sæt");
        treatments[3].setPrice(500);

        treatments[4].setName("Akryl ombre/babyboom");
        treatments[4].setPrice(500);

        for (; i < 5; i++) {
            treatments[i].setCategory(categories[0]);
        }

        treatments[5].setName("Akryl naturlig sæt");
        treatments[5].setPrice(325);

        treatments[6].setName("Akryl pink og hvid sæt");
        treatments[6].setPrice(445);

        treatments[7].setName("Akryl med gellak sæt");
        treatments[7].setPrice(445);

        treatments[8].setName("Akryl med glitter sæt");
        treatments[8].setPrice(500);

        treatments[9].setName("Akryl med ombre/babyboom");
        treatments[9].setPrice(500);

        for (; i < 10; i++) {
            treatments[i].setCategory(categories[1]);
        }

        treatments[10].setName("Gele naturlig sæt");
        treatments[10].setPrice(435);

        treatments[11].setName("Gele pink og hvid sæt");
        treatments[11].setPrice(535);

        treatments[12].setName("Gele med gellak sæt");
        treatments[12].setPrice(535);

        treatments[13].setName("Gele med glitter sæt");
        treatments[13].setPrice(535);

        treatments[14].setName("Gele ombreb/abyboom");
        treatments[14].setPrice(535);

        for (; i < 15; i++) {
            treatments[i].setCategory(categories[2]);
        }

        treatments[15].setName("Gele naturlig sæt");
        treatments[15].setPrice(395);

        treatments[16].setName("Gele pink og hvid sæt");
        treatments[16].setPrice(495);

        treatments[17].setName("Gele med gellak sæt");
        treatments[17].setPrice(495);

        treatments[18].setName("Gele med glitter sæt");
        treatments[18].setPrice(495);

        treatments[19].setName("Gele ombre/babyboom");
        treatments[19].setPrice(495);

        for (; i < 20; i++) {
            treatments[i].setCategory(categories[3]);
        }

        treatments[20].setName("Reparation en af negl");
        treatments[20].setPrice(80);

        treatments[21].setName("Fjernelse af helt sæt");
        treatments[21].setPrice(199);

        treatments[22].setName("Fjernelse af gellak");
        treatments[22].setPrice(129);

        treatments[23].setName("Fjernelse af negle og påsætning");

        treatments[24].setName("Nyt sæt tillæg");
        treatments[24].setPrice(50);

        for (; i < 25; i++) {
            treatments[i].setCategory(categories[4]);
        }

        treatments[25].setName("Halvt ben");
        treatments[25].setPrice(299);

        treatments[26].setName("Helt ben");
        treatments[26].setPrice(499);

        treatments[27].setName("Ryggen");
        treatments[27].setPrice(399);

        for (; i < 28; i++) {
            treatments[i].setCategory(categories[5]);
        }

        treatments[28].setName("Dipping naturlig sæt");
        treatments[28].setPrice(435);

        treatments[29].setName("Dipping pink og hvid sæt");
        treatments[29].setPrice(535);

        treatments[30].setName("Dipping med gellak sæt");
        treatments[30].setPrice(535);

        treatments[31].setName("Dipping med glitter sæt");
        treatments[31].setPrice(535);

        treatments[32].setName("Dipping ombre/babyboom");
        treatments[32].setPrice(535);

        for (; i < 33; i++) {
            treatments[i].setCategory(categories[6]);
        }

        treatments[33].setName("Dipping naturlig sæt");
        treatments[33].setPrice(395);

        treatments[34].setName("Dipping pink og hvid sæt");
        treatments[34].setPrice(495);

        treatments[35].setName("Dipping med gellak sæt");
        treatments[35].setPrice(495);

        treatments[36].setName("Dipping med glitter sæt");
        treatments[36].setPrice(495);

        treatments[37].setName("Dipping ombre/babyboom");
        treatments[37].setPrice(495);

        for (; i < 38; i++) {
            treatments[i].setCategory(categories[7]);
        }

        treatments[38].setName("Manicure klassisk");
        treatments[38].setPrice(199);

        treatments[39].setName("Manicure med lak");
        treatments[39].setPrice(249);

        treatments[40].setName("Manicure med gellak");
        treatments[40].setPrice(359);

        treatments[41].setName("Pedicure klassisk");
        treatments[41].setPrice(299);

        treatments[42].setName("Pedicure med lak");
        treatments[42].setPrice(349);

        treatments[43].setName("Pedicure med gellak");
        treatments[43].setPrice(399);

        treatments[44].setName("Pedicure og Manicure");
        treatments[44].setPrice(499);

        treatments[45].setName("Almindelig lak");
        treatments[45].setPrice(120);

        treatments[46].setName("Gellak");
        treatments[46].setPrice(299);

        treatments[47].setName("Fransk polering");
        treatments[47].setPrice(120);

        for (; i < 48; i++) {
            treatments[i].setCategory(categories[8]);
        }

        treatments[48].setName("Design på alle neglene");
        treatments[48].setPrice(199);

        treatments[49].setName("Design på 1 stk/2 stk");
        treatments[49].setPrice(50);

        treatments[50].setName("Sten");
        treatments[50].setPrice(70);

        for (; i < 51; i++) {
            treatments[i].setCategory(categories[9]);
        }

        treatments[51].setName("Sinlge klassisk nyt sæt");
        treatments[51].setPrice(599);

        treatments[52].setName("Opfyldning");
        treatments[52].setPrice(399);

        treatments[53].setName("Eyelash volume ny sæt");
        treatments[53].setPrice(799);

        treatments[54].setName("Opfyldning volume");
        treatments[54].setPrice(599);

        treatments[55].setName("Lash Lift colagen");
        treatments[55].setPrice(350);

        for (; i < 56; i++) {
            treatments[i].setCategory(categories[10]);
        }

        treatments[56].setName("Retning af bryn");
        treatments[56].setPrice(100);

        treatments[57].setName("Farvning af bryn");
        treatments[57].setPrice(100);

        treatments[58].setName("Farve og retning af bryn");
        treatments[58].setPrice(180);

        for (; i < 59; i++) {
            treatments[i].setCategory(categories[11]);
        }

        treatmentRepository.saveAll(Arrays.asList(treatments));
    }
    
}
