package dk.nailsalondeluxe.backend.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.MediaTypeFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import dk.nailsalondeluxe.backend.model.Category;
import dk.nailsalondeluxe.backend.model.CategoryImage;
import dk.nailsalondeluxe.backend.model.Treatment;
import dk.nailsalondeluxe.backend.repository.CategoryImageRepository;
import dk.nailsalondeluxe.backend.repository.CategoryRepository;
import dk.nailsalondeluxe.backend.repository.TreatmentRepository;

@Component
public class InitData implements CommandLineRunner {

    private CategoryRepository categoryRepository;
    private TreatmentRepository treatmentRepository;
    private CategoryImageRepository categoryImageRepository;

    public InitData(CategoryRepository categoryRepository,
                    TreatmentRepository treatmentRepository,
                    CategoryImageRepository categoryImageRepository) {
 
        this.categoryRepository = categoryRepository;
        this.treatmentRepository = treatmentRepository;
        this.categoryImageRepository = categoryImageRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Category[] categories = getCategories();
        categoryRepository.saveAll(Arrays.asList(categories));

        Treatment[] treatments = getTreatments(categories);
        treatmentRepository.saveAll(Arrays.asList(treatments));

        CategoryImage[] images = getCategoryImages(categories);
        categoryImageRepository.saveAll(Arrays.asList(images));
    }
    
    private Category[] getCategories() {

        int categoryAmount = 12;
        Category[] categories = new Category[categoryAmount];

        for (int i = 0; i < categoryAmount; i++) {
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

        return categories;
    }

    private Treatment[] getTreatments(Category[] categories) {

        int treatmentAmount = 59;
        Treatment[] treatments = new Treatment[treatmentAmount];

        int index = 0;
        while (index < treatmentAmount) {
            treatments[index] = new Treatment();
            index++;
        }
        index = 0;

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

        while (index < 5) {
            treatments[index].setCategory(categories[0]);
            index++;
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

        while (index < 10) {
            treatments[index].setCategory(categories[1]);
            index++;
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

        while (index < 15) {
            treatments[index].setCategory(categories[2]);
            index++;
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

        while (index < 20) {
            treatments[index].setCategory(categories[3]);
            index++;
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

        while (index < 25) {
            treatments[index].setCategory(categories[4]);
            index++;
        }

        treatments[25].setName("Halvt ben");
        treatments[25].setPrice(299);

        treatments[26].setName("Helt ben");
        treatments[26].setPrice(499);

        treatments[27].setName("Ryggen");
        treatments[27].setPrice(399);

        while (index < 28) {
            treatments[index].setCategory(categories[5]);
            index++;
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

        while (index < 33) {
            treatments[index].setCategory(categories[6]);
            index++;
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

        while (index < 38) {
            treatments[index].setCategory(categories[7]);
            index++;
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

        while (index < 48) {
            treatments[index].setCategory(categories[8]);
            index++;
        }

        treatments[48].setName("Design på alle neglene");
        treatments[48].setPrice(199);

        treatments[49].setName("Design på 1 stk/2 stk");
        treatments[49].setPrice(50);

        treatments[50].setName("Sten");
        treatments[50].setPrice(70);

        while (index < 51) {
            treatments[index].setCategory(categories[9]);
            index++;
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

        while (index < 56) {
            treatments[index].setCategory(categories[10]);
            index++;
        }

        treatments[56].setName("Retning af bryn");
        treatments[56].setPrice(100);

        treatments[57].setName("Farvning af bryn");
        treatments[57].setPrice(100);

        treatments[58].setName("Farve og retning af bryn");
        treatments[58].setPrice(180);

        while (index < treatmentAmount) {
            treatments[index].setCategory(categories[11]);
            index++;
        }

        return treatments;
    }
    
    private CategoryImage[] getCategoryImages(Category[] categories) throws FileNotFoundException, IOException {
        
        int imageAmount = 4;
        CategoryImage[] images = new CategoryImage[imageAmount];

        for (int i = 0; i < imageAmount; i++) {
            images[i] = new CategoryImage();
        }

        String file0Name = "kunstige negle.jpg";
        File file0 = ResourceUtils.getFile("classpath:images/%s".formatted(file0Name));
        images[0].setFileName(file0Name);
        images[0].setMimeType(MediaTypeFactory.getMediaType(file0Name).get().toString());
        images[0].setLastModified(file0.lastModified());
        images[0].setImageData(FileUtils.readFileToByteArray(file0));
        images[0].setCategory(categories[0]);

        String file1Name = "påfyldning naturlig sæt.jpg";
        File file1 = ResourceUtils.getFile("classpath:images/%s".formatted(file1Name));
        images[1].setFileName(file1Name);
        images[1].setMimeType(MediaTypeFactory.getMediaType(file1Name).get().toString());
        images[1].setLastModified(file1.lastModified());
        images[1].setImageData(FileUtils.readFileToByteArray(file1));
        images[1].setCategory(categories[1]);

        String file2Name = "negle.jpg";
        File file2 = ResourceUtils.getFile("classpath:images/%s".formatted(file2Name));
        images[2].setFileName(file2Name);
        images[2].setMimeType(MediaTypeFactory.getMediaType(file2Name).get().toString());
        images[2].setLastModified(file2.lastModified());
        images[2].setImageData(FileUtils.readFileToByteArray(file2));
        images[2].setCategory(categories[2]);

        String file3Name = "dipping powder negle.jpg";
        File file3 = ResourceUtils.getFile("classpath:images/%s".formatted(file3Name));
        images[3].setFileName(file3Name);
        images[3].setMimeType(MediaTypeFactory.getMediaType(file3Name).get().toString());
        images[3].setLastModified(file3.lastModified());
        images[3].setImageData(FileUtils.readFileToByteArray(file3));
        images[3].setCategory(categories[6]);

        return images;
    }
}
