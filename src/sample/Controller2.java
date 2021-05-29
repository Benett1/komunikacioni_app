package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controller2{
    @FXML
    public Label User_name_label;
    public AnchorPane drop_options;
    public Button drop_btn;
    public Button quizz_btn;
    public AnchorPane quizz_panel;
    public AnchorPane chapter_one_pane;
    public AnchorPane chapter_two_pane;
    public AnchorPane chapter_three_pane;
    public Button back_btn;
    public Button front_btn;
    public Button Perfundo_kuizz_btn;
    public Label titulli;
    public Label kuiz_timer;
    public Label pergjigje_gabim;
    public Label pergjigje_sakt;
    public Label rezultati;

    //chapet 1
    public AnchorPane chapter_one_page1;
    public AnchorPane chapter_one_page2;
    public AnchorPane chapter_one_page3;
    public AnchorPane chapter_one_page4;
    //chaper 2
    public AnchorPane chapter_two_page1;
    public AnchorPane chapter_two_page2;
    public AnchorPane chapter_two_page3;
    public AnchorPane chapter_two_page4;
    public AnchorPane chapter_two_page5;
    //chapter 3
    public AnchorPane chapter_three_page3;
    public AnchorPane chapter_three_page2;
    public AnchorPane chapter_three_page1;
    //kuiz
    public AnchorPane Kuiz_page_1;
    public AnchorPane Kuiz_page_2;
    public AnchorPane Kuiz_page_3;
    public AnchorPane Kuiz_page_4;
    public Button Quiz_mbrapa;
    public Button Quiz_para;
    public Label page_label;
    public RadioButton Kuiz_btn_page_1_1;
    public RadioButton Kuiz_btn_page_1_2;
    public RadioButton Kuiz_btn_page_2_1;
    public RadioButton Kuiz_btn_page_2_2;
    public RadioButton Kuiz_btn_page_2_3;
    public RadioButton Kuiz_btn_page_3_1;
    public RadioButton Kuiz_btn_page_3_2;
    public RadioButton Kuiz_btn_page_3_3;
    public RadioButton Kuiz_btn_page_4_1;
    public RadioButton Kuiz_btn_page_4_2;

    //radio buttons
    ToggleGroup tg_page_1 = new ToggleGroup();
    ToggleGroup tg_page_2 = new ToggleGroup();
    ToggleGroup tg_page_3 = new ToggleGroup();
    ToggleGroup tg_page_4 = new ToggleGroup();

    //other stuff
    public Pane Before_kuiz;
    public Pane After_kuiz;
    Timeline timeline = new Timeline();

    //variables
    int click = 0;
    int page_ch_1 = 1;
    int page_ch_2 = 1;
    int page_ch_3 = 1;
    int page_ch_4 = 1;
    int chapter = 1;
    int Kuiz_sakta = 0;
    int Kuiz_pa_sakta = 0;
    //quiz_timer tell us if we are currrently taking a quizz
    boolean quiz_timer = false;

    public void Mesimet_menu_button(ActionEvent actionEvent) throws Exception {

        if (click%2==0) {
            drop_options.setPrefHeight(305);
            drop_options.setVisible(true);
            quizz_btn.setLayoutY(450);
            click++;
        }else{
            drop_options.setPrefHeight(39);
            drop_options.setVisible(false);
            quizz_btn.setLayoutY(194);
            click++;
        }
    }

    public void chapter_1_btn(ActionEvent mouseEvent) {
        if(!quizz_timer(quiz_timer,chapter_one_pane)){
            return;
        }
        ((Stage)quizz_btn.getScene().getWindow()).setResizable(true);
        titulli.setText("Kapitulli i parë");
        chapter_one_pane.setVisible(true);
        chapter_two_pane.setVisible(false);
        chapter_three_pane.setVisible(false);
        quizz_panel.setVisible(false);
        Before_kuiz.setVisible(false);
        After_kuiz.setVisible(false);
        chapter = 1;
        back_btn.setVisible(true);
        front_btn.setVisible(true);
        page_label.setText("Faqe " + page_ch_1);
        page_label.setVisible(true);

    }

    public void chapter_2_btn(ActionEvent mouseEvent) {
        if (!quizz_timer(quiz_timer, chapter_two_pane)) {
            return;
        }
        ((Stage)quizz_btn.getScene().getWindow()).setResizable(true);
        titulli.setText("Kapitulli i dytë");
        chapter_two_pane.setVisible(true);
        chapter_one_pane.setVisible(false);
        chapter_three_pane.setVisible(false);
        quizz_panel.setVisible(false);
        Before_kuiz.setVisible(false);
        After_kuiz.setVisible(false);
        chapter = 2;
        back_btn.setVisible(true);
        front_btn.setVisible(true);
        page_label.setText("Faqe " + page_ch_2);
        page_label.setVisible(true);
    }

    public void chapter_3_btn(ActionEvent mouseEvent) {
        if (!quizz_timer(quiz_timer, chapter_three_pane)){
            return;
        }
        ((Stage)quizz_btn.getScene().getWindow()).setResizable(true);
        titulli.setText("Kapitulli i tretë");
        chapter_three_pane.setVisible(true);
        chapter_one_pane.setVisible(false);
        chapter_two_pane.setVisible(false);
        quizz_panel.setVisible(false);
        Before_kuiz.setVisible(false);
        After_kuiz.setVisible(false);
        chapter = 3;
        back_btn.setVisible(true);
        front_btn.setVisible(true);
        page_label.setText("Faqe " + page_ch_3);
        page_label.setVisible(true);
    }
    public void quizz_btn(ActionEvent actionEvent) {
        if (!quiz_timer) {
            titulli.setText("Kuiz");
            Before_kuiz.setVisible(true);
            After_kuiz.setVisible(false);
            quizz_panel.setVisible(false);
            back_btn.setVisible(false);
            front_btn.setVisible(false);
            page_label.setVisible(false);
            chapter_one_pane.setVisible(false);
            chapter_three_pane.setVisible(false);
            chapter_two_pane.setVisible(false);

            chapter = 4;
            page_ch_4 = 1;
            page_label.setText("Pyetja e " + page_ch_4);

            Kuiz_btn_page_1_1.setToggleGroup(tg_page_1);
            Kuiz_btn_page_1_2.setToggleGroup(tg_page_1);

            Kuiz_btn_page_2_1.setToggleGroup(tg_page_2);
            Kuiz_btn_page_2_2.setToggleGroup(tg_page_2);
            Kuiz_btn_page_2_3.setToggleGroup(tg_page_2);

            Kuiz_btn_page_3_1.setToggleGroup(tg_page_3);
            Kuiz_btn_page_3_2.setToggleGroup(tg_page_3);
            Kuiz_btn_page_3_3.setToggleGroup(tg_page_3);

            Kuiz_btn_page_4_1.setToggleGroup(tg_page_4);
            Kuiz_btn_page_4_2.setToggleGroup(tg_page_4);
        }
    }
    //when we start quizz with this method we initialize the right components, and other procedures.
    public void kuiz_btn_continuer() {
        int Kuiz_minutes = 5;
        int Kuiz_second = 0;
        After_kuiz.setVisible(false);
        Before_kuiz.setVisible(false);
        quiz_timer =true;
        page_label.setLayoutX(1650);
        page_label.setVisible(true);
        page_ch_4 = 1;
        page_label.setText("Pyetja e " + page_ch_4);
        kuiz_timer.setText(Kuiz_minutes + ":" + Kuiz_second +"0");
        page(1,4);
        timer(Kuiz_minutes, Kuiz_second);
    }
    private boolean quizz_timer(boolean quicktm,AnchorPane chapter) {
        if (quicktm) {
            Alert error = new Alert(Alert.AlertType.CONFIRMATION);
            error.setHeaderText("Nese vendosni te dilni nga ky panel pergjigjet e selektuara do te humbin.");
            error.showAndWait();
            if (error.getResult() == ButtonType.OK) {
                back_btn.setLayoutY(801);
                front_btn.setLayoutY(801);
//                page_label.setLayoutX(1600);
                Quiz_mbrapa.setVisible(false);
                Quiz_para.setVisible(false);
                quiz_timer = false;
                Kuiz_btn_reset();
                quizz_panel.setVisible(false);
                After_kuiz.setVisible(false);
                chapter.setVisible(true);
                timeline.stop();
                return true;
            } else if (error.getResult() == ButtonType.CANCEL) {
                quizz_panel.setVisible(true);
                chapter.setVisible(false);
                return false;
            }
        }
        return true;
    }
    //metoda e ores, ketu e perdorim timeline qe te mos e pauzojme aplikacionin
    public void timer(int min,int sec){
        final int[] minutes = {min};
        final int[] seconds = {sec};
        timeline.stop();
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(1),
                        new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent event) {
                                if (seconds[0] == 0) {
                                    minutes[0]--;
                                    seconds[0] = 59;
                                }else{
                                    seconds[0]--;
                                }
                                if (minutes[0] == 0 && seconds[0] == 0) {
                                    After_kuiz.setVisible(true);
                                    quiz_timer = false;
                                    Alert end_kuiz = new Alert(Alert.AlertType.INFORMATION);
                                    end_kuiz.setContentText("Kuizi mbaroi");
                                }
                                if (seconds[0] < 10) {
                                    kuiz_timer.setText(minutes[0] + ":" + "0" + seconds[0]);
                                }else {
                                    kuiz_timer.setText(minutes[0] + ":" + seconds[0]);
                                }
                            }
                        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    public void back_btn_click(MouseEvent mouseEvent) {
        if (chapter == 1){
            if (page_ch_1>1) {
                page_ch_1 -=1;
                page(page_ch_1,chapter);
                page_label.setText("Faqe " + page_ch_1);
            }
        }else if(chapter == 2){
            if (page_ch_2>1) {
                page_ch_2 -=1;
                page(page_ch_2,chapter);
                page_label.setText("Faqe " + page_ch_2);
            }
        }else if(chapter == 3){
            if (page_ch_3>1) {
                page_ch_3 -=1;
                page(page_ch_3,chapter);
                page_label.setText("Faqe " + page_ch_3);
            }
        }
        else if(chapter == 4){
            if (page_ch_4>1) {
                page_ch_4 -=1;
                page(page_ch_4,chapter);
                page_label.setText("Pyetja e " + page_ch_4);
            }
        }
    }
    public void front_btn_click(MouseEvent mouseEvent) {
        if (chapter == 1){
            if (page_ch_1<4) {
                page_ch_1 += 1;
                page(page_ch_1,chapter);
                page_label.setText("Faqe " + page_ch_1);
            }
        }else if(chapter == 2){
            if (page_ch_2<5) {
                page_ch_2 += 1;
                page(page_ch_2,chapter);
                page_label.setText("Faqe " + page_ch_2);
            }
        }
        else if(chapter == 3){
            if (page_ch_3<3) {
                page_ch_3 += 1;
                page(page_ch_3,chapter);
                page_label.setText("Faqe " + page_ch_3);
            }
        }
        else if(chapter == 4){
            if (page_ch_4<4) {
                page_ch_4 += 1;
                page(page_ch_4,chapter);
                page_label.setText("Pyetja e " + page_ch_4);
            }
        }
    }
    //to reset quiz answers to none
    public void Kuiz_btn_reset(){
        Kuiz_btn_page_1_1.setSelected(false);
        Kuiz_btn_page_1_2.setSelected(false);
        Kuiz_btn_page_2_1.setSelected(false);
        Kuiz_btn_page_2_2.setSelected(false);
        Kuiz_btn_page_2_3.setSelected(false);
        Kuiz_btn_page_3_1.setSelected(false);
        Kuiz_btn_page_3_2.setSelected(false);
        Kuiz_btn_page_3_3.setSelected(false);
        Kuiz_btn_page_4_1.setSelected(false);
        Kuiz_btn_page_4_2.setSelected(false);
    }
    //when we press forward(para) button, we update the page by giving the chapter and the page which we need to be
    public void page(int page,int chapter){
        if (chapter == 1) {
            switch (page) {
                case 1:
                    chapter_one_page2.setVisible(false);
                    chapter_one_page1.setVisible(true);
                    chapter_one_page3.setVisible(false);
                    chapter_one_page4.setVisible(false);
                    break;
                case 2:
                    chapter_one_page2.setVisible(true);
                    chapter_one_page1.setVisible(false);
                    chapter_one_page3.setVisible(false);
                    chapter_one_page4.setVisible(false);
                    break;
                case 3:
                    chapter_one_page1.setVisible(false);
                    chapter_one_page2.setVisible(false);
                    chapter_one_page3.setVisible(true);
                    chapter_one_page4.setVisible(false);
                    break;
                case 4:
                    chapter_one_page2.setVisible(false);
                    chapter_one_page1.setVisible(false);
                    chapter_one_page3.setVisible(false);
                    chapter_one_page4.setVisible(true);
                    break;
            }
        }else if (chapter == 2) {
            switch (page) {
                case 1:
                    chapter_two_page1.setVisible(true);
                    chapter_two_page2.setVisible(false);
                    chapter_two_page3.setVisible(false);
                    chapter_two_page5.setVisible(false);
                    chapter_two_page4.setVisible(false);
                    break;
                case 2:
                    chapter_two_page2.setVisible(true);
                    chapter_two_page1.setVisible(false);
                    chapter_two_page3.setVisible(false);
                    chapter_two_page5.setVisible(false);
                    chapter_two_page4.setVisible(false);
                    break;
                case 3:
                    chapter_two_page3.setVisible(true);
                    chapter_two_page2.setVisible(false);
                    chapter_two_page1.setVisible(false);
                    chapter_two_page5.setVisible(false);
                    chapter_two_page4.setVisible(false);
                    break;
                case 4:
                    chapter_two_page4.setVisible(true);
                    chapter_two_page3.setVisible(false);
                    chapter_two_page2.setVisible(false);
                    chapter_two_page1.setVisible(false);
                    chapter_two_page5.setVisible(false);
                    break;
                case 5:
                    chapter_two_page5.setVisible(true);
                    chapter_two_page4.setVisible(false);
                    chapter_two_page3.setVisible(false);
                    chapter_two_page2.setVisible(false);
                    chapter_two_page1.setVisible(false);
                    break;
            }
        }
        else if (chapter == 3) {
            switch (page) {
                case 1:
                    chapter_three_page1.setVisible(true);
                    chapter_three_page2.setVisible(false);
                    chapter_three_page3.setVisible(false);
                    break;
                case 2:
                    chapter_three_page2.setVisible(true);
                    chapter_three_page1.setVisible(false);
                    chapter_three_page3.setVisible(false);
                    break;
                case 3:
                    chapter_three_page3.setVisible(true);
                    chapter_three_page2.setVisible(false);
                    chapter_three_page1.setVisible(false);
                    break;
            }
        }
        else if(chapter == 4){
            switch (page){
                case 1:
                    Kuiz_page_1.setVisible(true);
                    Kuiz_page_2.setVisible(false);
                    Kuiz_page_3.setVisible(false);
                    Kuiz_page_4.setVisible(false);
                    break;
                case 2:
                    Kuiz_page_2.setVisible(true);
                    Kuiz_page_1.setVisible(false);
                    Kuiz_page_3.setVisible(false);
                    Kuiz_page_4.setVisible(false);
                    break;
                case 3:
                    Kuiz_page_3.setVisible(true);
                    Kuiz_page_2.setVisible(false);
                    Kuiz_page_1.setVisible(false);
                    Kuiz_page_4.setVisible(false);
                    Quiz_para.setVisible(true);
                    Perfundo_kuizz_btn.setVisible(false);
                    break;
                case 4:
                    Kuiz_page_4.setVisible(true);
                    Kuiz_page_1.setVisible(false);
                    Kuiz_page_2.setVisible(false);
                    Kuiz_page_3.setVisible(false);
                    Quiz_para.setVisible(false);
                    Perfundo_kuizz_btn.setVisible(true);
                    break;
            }
        }
    }
    // when we are in quiz panel, before we start the quiz we have a button to confirm that we want to start th quiz. This is that button.
    public void Vazhdo_click(ActionEvent event) {
        quiz_timer =true;
        Perfundo_kuizz_btn.setVisible(false);
        Before_kuiz.setVisible(false);
        quizz_panel.setVisible(true);
        kuiz_btn_continuer();
        Kuiz_btn_reset();
        Kuiz_sakta=0;
        Kuiz_pa_sakta=0;
        back_btn.setVisible(false);
        front_btn.setVisible(false);
        Quiz_mbrapa.setVisible(true);
        Quiz_para.setVisible(true);
    }
    public void Perfundo_kuizz_btn_click(ActionEvent event){
        quizz_panel.setVisible(false);
        After_kuiz.setVisible(true);
        back_btn.setVisible(false);
        page_label.setVisible(false);
        Quiz_mbrapa.setVisible(false);
        Quiz_para.setVisible(false);


        RadioButton pyetja_1 = (RadioButton)tg_page_1.getSelectedToggle();
        RadioButton pyetja_2 = (RadioButton)tg_page_2.getSelectedToggle();
        RadioButton pyetja_3 = (RadioButton)tg_page_3.getSelectedToggle();
        RadioButton pyetja_4 = (RadioButton)tg_page_4.getSelectedToggle();
        //here we are checking if the user answers are correct
        if (pyetja_1 != null) {
            String s = pyetja_1.getText();
            if (s.equals("Fotoja numër 2")){
                Kuiz_sakta++;
            }
            else{
                Kuiz_pa_sakta++;
            }
        }else{
            Kuiz_pa_sakta++;
        }
        if (pyetja_2 != null) {
            String s = pyetja_2.getText();
            if (s.equals("Të gjithë hapat")){
                Kuiz_sakta++;
            }else {
                Kuiz_pa_sakta++;
            }
        }else{
            Kuiz_pa_sakta++;
        }
        if (pyetja_3 != null) {
            String s = pyetja_3.getText();
            if (s.equals("B")){
                Kuiz_sakta++;
            }else{
                Kuiz_pa_sakta++;
            }
        }else{
            Kuiz_pa_sakta++;
        }
        if (pyetja_4 != null) {
            String s = pyetja_4.getText();
            if (s.equals("Nëse nuk është e nevojshme më mirë është që të mos e kalojmë rrugën")){
                Kuiz_sakta++;
            }else{
                Kuiz_pa_sakta++;
            }
        }else{
            Kuiz_pa_sakta++;
        }
        pergjigje_gabim.setText("Numri i përgjigjeve të gabuara: " + Kuiz_pa_sakta);
        pergjigje_sakt.setText("Numri i përgjigjeve të sakta: " + Kuiz_sakta);
        rezultati.setText("Rezultati: " + Kuiz_sakta + "/4");
        //then we stop the quiz_timer to tell the program that we have finished the quiz.
        quiz_timer = false;
    }
}