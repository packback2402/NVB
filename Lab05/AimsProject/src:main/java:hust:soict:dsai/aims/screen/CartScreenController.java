package hust.soict.dsai.aims.screen;

import hust.soict.dsai.Aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {
    private final Cart cart;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Double> colMediaCost;

    @FXML
    private Label lblTotalCost;

    @FXML
    private TextField txtFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private Button btnRemove;

    @FXML
    private Button btnPlay;

    private FilteredList<Media> filteredList;

    public CartScreenController(Cart cart) {
        this.cart = cart;
    }

    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        filteredList = new FilteredList<>(cart.getItemsOrdered(), media -> true);
        tblMedia.setItems(filteredList);
        updateTotalCost();
        // Listen for cart changes to update total cost automatically
        cart.getItemsOrdered().addListener((javafx.collections.ListChangeListener<Media>) c -> {
            tblMedia.refresh();
        });

        txtFilter.textProperty().addListener((observable, oldValue, newValue) -> showFilteredMedia(newValue));

        tblMedia.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                updateButtonBar(newValue);
            } else {
                btnRemove.setVisible(false);
                btnPlay.setVisible(false);
            }
        });

        btnRemove.setVisible(false);
        btnPlay.setVisible(false);
    }

    private void applyFilter(String filter) {
        filteredList.setPredicate(media -> {
            if (filter == null || filter.isEmpty()) {
                return true;
            }

            String lowerCaseFilter = filter.toLowerCase();
            if (radioBtnFilterId.isSelected()) {
                return String.valueOf(media.getId()).contains(lowerCaseFilter);
            } else if (radioBtnFilterTitle.isSelected()) {
                return media.getTitle().toLowerCase().contains(lowerCaseFilter);
            }
            return false;
        });
    }

    private void updateTotalCost() {
        lblTotalCost.setText(String.format("$%.2f", cart.totalCost()));
    }

    private void showFilteredMedia(String filter) {
        applyFilter(filter);
    }

    private void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        btnPlay.setVisible(media instanceof hust.soict.dsai.aims.media.Playable);
    }

    @FXML
    private void btnRemovePressed(ActionEvent event) {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
        if (selectedMedia != null) {
            cart.removeMedia(selectedMedia);
            updateTotalCost();
            btnRemove.setVisible(false);
            btnPlay.setVisible(false);
            System.out.println("Removed: " + selectedMedia.getTitle());
        } else {
            System.out.println("No item selected for removal.");
        }
    }

    @FXML
    private void btnPlayPressed(ActionEvent event) throws PlayerException {
        Media selectedMedia = tblMedia.getSelectionModel().getSelectedItem();
        if (selectedMedia instanceof hust.soict.dsai.aims.media.Playable playable) {
            playable.play();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Playing Media");
            alert.setHeaderText(null);
            alert.setContentText("Playing: " + selectedMedia.getTitle());
            alert.showAndWait();
        }
    }

    @FXML
    private void btnPlaceOrderPressed(ActionEvent event) {
        cart.getItemsOrdered().clear();
        updateTotalCost();
        System.out.println("Order placed successfully!");
    }

    @FXML
    private void menuViewStoreAction(ActionEvent event) {
        if (Aims.getStoreScreenInstance() != null) {
            Aims.getStoreScreenInstance().setExtendedState(java.awt.Frame.NORMAL);
            Aims.getStoreScreenInstance().toFront();
            Aims.getStoreScreenInstance().requestFocus();
        } else {
            // Fallback if instance is null
            new StoreScreen(Aims.getStore(), Aims.getCart());
        }
    }
}
