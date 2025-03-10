package Controller;

import Model.ItemCardapio;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class TelaInicialController {

    @FXML public CheckBox checkBoxMediaCalabresa;
    @FXML public CheckBox checkBoxFamiliaCalabresa;
    @FXML public CheckBox checkBoxGiganteCalabresa;
    @FXML public CheckBox checkBoxMediaCatupiry;
    @FXML public CheckBox checkBoxFamiliaCatupiry;
    @FXML public CheckBox checkBoxGiganteCatupiry;
    @FXML public CheckBox checkBoxMediaPepperoni;
    @FXML public CheckBox checkBoxFamiliaPepperoni;
    @FXML public CheckBox checkBoxGigantePepperoni;

    @FXML private VBox vBoxHamb;
    @FXML private VBox vBoxPizza;
    @FXML private VBox vBoxPastel;
    @FXML private VBox vBoxBebidas;
    @FXML private ScrollPane scrollPane;
    @FXML private Button buttonHamb;
    @FXML private Button buttonPizza;
    @FXML private Button buttonPastel;
    @FXML private Button buttonBebida;
    @FXML private Button buttonMaisSmash;
    @FXML private Button buttonMaisSalada;
    @FXML private Button buttonMaisBacon;
    @FXML private Button buttonMaisPastelFrango;
    @FXML private Button buttonMaisPastelCarne;
    @FXML private Button buttonMaisPastelCamarao;
    @FXML private Button buttonMaisPastelQueijo;
    @FXML private Button buttonMaisCalabresa;
    @FXML private Button buttonMaisFrangoCatupiry;
    @FXML private Button buttonMaisPepperoni;
    @FXML private Button buttonMenosSmash;
    @FXML private Button buttonMenosSalada;
    @FXML private Button buttonMenosBacon;
    @FXML private Button buttonMenosPastelFrango;
    @FXML private Button buttonMenosPastelCarne;
    @FXML private Button buttonMenosPastelCamarao;
    @FXML private Button buttonMenosPastelQueijo;
    @FXML private Button buttonMenosCalabresa;
    @FXML private Button buttonMenosFrangoCatupiry;
    @FXML private Button buttonMenosPepperoni;
    @FXML private Button buttonAgua;
    @FXML private Button buttonCarrinho;
    @FXML private Label labelSmash;
    @FXML private Label labelSalada;
    @FXML private Label labelBacon;
    @FXML private Label labelPastelFrango;
    @FXML private Label labelPastelCarne;
    @FXML private Label labelPastelCamarao;
    @FXML private Label labelPastelQueijo;
    @FXML private Label labelCalabresa;
    @FXML private Label labelFrangoCatupiry;
    @FXML private Label labelPepperoni;
    @FXML private Label labelTotal;

    private GerenciadorCardapio gerenciadorCardapio;
    private ItemManager itemManager;

    public void abrirCarrinho() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Carrinho.fxml"));

        Stage stage = new Stage();

        stage.setTitle("Carrinho");
        stage.setScene(new Scene(root, 615, 700));
        stage.show();

    }

    public void scrollHamb() {
        scrollPane.setVvalue(vBoxHamb.getLayoutY() / scrollPane.getContent().getBoundsInLocal().getHeight());
    }

    public void scrollPastel() {
        scrollPane.setVvalue(vBoxPastel.getLayoutY() / scrollPane.getContent().getBoundsInLocal().getHeight());
    }

    public void scrollPizza() {
        scrollPane.setVvalue(vBoxPizza.getLayoutY() / scrollPane.getContent().getBoundsInLocal().getHeight());
    }

    public void scrollBebida() {
        scrollPane.setVvalue(vBoxBebidas.getLayoutY() / scrollPane.getContent().getBoundsInLocal().getHeight());
    }

    @FXML public void initialize() {
        gerenciadorCardapio = new GerenciadorCardapio();
        itemManager = new ItemManager(gerenciadorCardapio, this);

        //Adicionar
        buttonMaisSmash.setOnAction(event -> {
            itemManager.adicionarItem("Smash Burguer", "Pão Brioche, Carne Smash 80g, Ovo, Cheddar e Molho da Casa.", 14.90, 1, labelSmash);
        });

        buttonMaisSalada.setOnAction(event -> {
            itemManager.adicionarItem("Smash Salada", "Pão Brioche, Carne Smash 80g, Alface, Cebola Crocante, Tomate, Picles e Molho da Casa.", 17.90, 1, labelSalada);
        });

        buttonMaisBacon.setOnAction(event -> {
           itemManager.adicionarItem("Smash Bacon", "Pão Brioche, Carne Smash 80g, Bacon, Cheddar e Molho da Casa.", 16.90, 1, labelBacon);
        });

        buttonMaisPastelFrango.setOnAction(event -> {
            itemManager.adicionarItem("Pastel Frango", "Frango Desfiado", 12.00, 1, labelPastelFrango);
        });

        buttonMaisPastelCarne.setOnAction(event -> {
            itemManager.adicionarItem("Pastel Carne", "Carne Moída", 12.00, 1, labelPastelCarne);
        });

        buttonMaisPastelCamarao.setOnAction(event -> {
            itemManager.adicionarItem("Pastel Camarão", "Camarão", 18.00, 1, labelPastelCamarao);
        });

        buttonMaisPastelQueijo.setOnAction(event -> {
            itemManager.adicionarItem("Pastel Queijo", "Queijo e Milho", 12.00, 1, labelPastelQueijo);
        });

        buttonMaisCalabresa.setOnAction(event -> {
            itemManager.adicionarPizza("Calabresa", "Molho, Mussarela, Calabresa, Tomate, Cebola, Azeitona e Orégano.", 35.00, 40.00, 45.00, 1, labelCalabresa);
        });


        //Remover
        buttonMenosSmash.setOnAction(event -> {
            itemManager.removerItem("Smash Burguer", labelSmash);
        });

        buttonMenosSalada.setOnAction(event -> {
            itemManager.removerItem("Smash Salada", labelSalada);
        });

        buttonMenosBacon.setOnAction(event -> {
            itemManager.removerItem("Smash Bacon", labelBacon);
        });

        buttonMenosPastelFrango.setOnAction(event -> {
            itemManager.removerItem("Pastel Frango", labelPastelFrango);
        });

        buttonMenosPastelCarne.setOnAction(event -> {
            itemManager.removerItem("Pastel Carne", labelPastelCarne);
        });

        buttonMenosPastelCamarao.setOnAction(event -> {
            itemManager.removerItem("Pastel Camarão", labelPastelCamarao);
        });

        buttonMenosPastelQueijo.setOnAction(event -> {
            itemManager.removerItem("Pastel Queijo", labelPastelQueijo);
        });


        //Verificação CheckBox
        checkBoxMediaCalabresa.setOnAction(event -> {
            if (checkBoxMediaCalabresa.isSelected()) {
                checkBoxFamiliaCalabresa.setSelected(false);
                checkBoxFamiliaCalabresa.setDisable(true);
                checkBoxGiganteCalabresa.setSelected(false);
                checkBoxGiganteCalabresa.setDisable(true);
            } else {
                checkBoxFamiliaCalabresa.setDisable(false);
                checkBoxGiganteCalabresa.setDisable(false);
            }
        });

        checkBoxFamiliaCalabresa.setOnAction(e -> {
            if (checkBoxFamiliaCalabresa.isSelected()) {
                checkBoxMediaCalabresa.setSelected(false);
                checkBoxMediaCalabresa.setDisable(true);
                checkBoxGiganteCalabresa.setSelected(false);
                checkBoxGiganteCalabresa.setDisable(true);
            } else {
                checkBoxMediaCalabresa.setDisable(false);
                checkBoxGiganteCalabresa.setDisable(false);
            }
        });

        checkBoxGiganteCalabresa.setOnAction(e -> {
            if (checkBoxGiganteCalabresa.isSelected()) {
                checkBoxFamiliaCalabresa.setSelected(false);
                checkBoxFamiliaCalabresa.setDisable(true);
                checkBoxMediaCalabresa.setSelected(false);
                checkBoxMediaCalabresa.setDisable(true);
            } else {
                checkBoxFamiliaCalabresa.setDisable(false);
                checkBoxMediaCalabresa.setDisable(false);
            }
        });

        checkBoxMediaCatupiry.setOnAction(e -> {
            if (checkBoxMediaCatupiry.isSelected()) {
                checkBoxFamiliaCatupiry.setSelected(false);
                checkBoxFamiliaCatupiry.setDisable(true);
                checkBoxGiganteCatupiry.setSelected(false);
                checkBoxGiganteCatupiry.setDisable(true);
            } else {
                checkBoxFamiliaCatupiry.setDisable(false);
                checkBoxGiganteCatupiry.setDisable(false);
            }
        });

        checkBoxFamiliaCatupiry.setOnAction(e -> {
            if (checkBoxFamiliaCatupiry.isSelected()) {
                checkBoxGiganteCatupiry.setSelected(false);
                checkBoxGiganteCatupiry.setDisable(true);
                checkBoxMediaCatupiry.setSelected(false);
                checkBoxMediaCatupiry.setDisable(true);
            } else {
                checkBoxGiganteCatupiry.setDisable(false);
                checkBoxMediaCatupiry.setDisable(false);
            }
        });

        checkBoxGiganteCatupiry.setOnAction(e -> {
            if (checkBoxGiganteCatupiry.isSelected()) {
                checkBoxFamiliaCatupiry.setSelected(false);
                checkBoxFamiliaCatupiry.setDisable(true);
                checkBoxMediaCatupiry.setSelected(false);
                checkBoxMediaCatupiry.setDisable(true);
            } else {
                checkBoxFamiliaCatupiry.setDisable(false);
                checkBoxMediaCatupiry.setDisable(false);
            }
        });

        checkBoxMediaPepperoni.setOnAction(e -> {
            if (checkBoxMediaPepperoni.isSelected()) {
                checkBoxFamiliaPepperoni.setSelected(false);
                checkBoxFamiliaPepperoni.setDisable(true);
                checkBoxGigantePepperoni.setSelected(false);
                checkBoxGigantePepperoni.setDisable(true);
            } else {
                checkBoxFamiliaPepperoni.setDisable(false);
                checkBoxGigantePepperoni.setDisable(false);
            }
        });

        checkBoxFamiliaPepperoni.setOnAction(e -> {
            if (checkBoxFamiliaPepperoni.isSelected()) {
                checkBoxGigantePepperoni.setSelected(false);
                checkBoxGigantePepperoni.setDisable(true);
                checkBoxMediaPepperoni.setSelected(false);
                checkBoxMediaPepperoni.setDisable(true);
            } else {
                checkBoxGigantePepperoni.setDisable(false);
                checkBoxMediaPepperoni.setDisable(false);
            }
        });

        checkBoxGigantePepperoni.setOnAction(e -> {
            if (checkBoxGigantePepperoni.isSelected()) {
                checkBoxFamiliaPepperoni.setSelected(false);
                checkBoxFamiliaPepperoni.setDisable(true);
                checkBoxMediaPepperoni.setSelected(false);
                checkBoxMediaPepperoni.setDisable(true);
            } else {
                checkBoxFamiliaPepperoni.setDisable(false);
                checkBoxMediaPepperoni.setDisable(false);
            }
        });


        //Scroll
        buttonHamb.setOnAction(event -> {
            scrollHamb();
        });

        buttonPizza.setOnAction(event -> {
            scrollPizza();
        });

        buttonPastel.setOnAction(event -> {
            scrollPastel();
        });

        buttonBebida.setOnAction(event -> {
            scrollBebida();
        });


        //Abri Carrinho
        buttonCarrinho.setOnAction(event -> {
            try {
                abrirCarrinho();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void atualizarTotal() { double total = gerenciadorCardapio.calcularTotal(); labelTotal.setText(String.format("%.2f", total)); }
}
