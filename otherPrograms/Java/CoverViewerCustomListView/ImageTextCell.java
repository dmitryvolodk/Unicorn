import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class ImageTextCell extends ListCell<Book> {
   private VBox vbox = new VBox(8.0); // 8 points of gap between controls
   private ImageView thumbImageView = new ImageView(); // initially empty
   private Label label = new Label();

   // Constructor configures VBox, ImageView and Label
   public ImageTextCell() {
      vbox.setAlignment(Pos.CENTER); // Center VBox contents horizontally

      thumbImageView.setPreserveRatio(true);
      thumbImageView.setFitHeight(100.0); // Thumbnail 100 points tall
      vbox.getChildren().add(thumbImageView); // Attach to Vbox

      label.setWrapText(true); // Wrap if text too wide to fit in label
      label.setTextAlignment(TextAlignment.CENTER); // Center text
      vbox.getChildren().add(label); // Attach to VBox

      setPrefWidth(USE_PREF_SIZE); // Use preferred size for cell width
   }

   // Called to configure each custom ListView cell
   @Override 
   protected void updateItem(Book item, boolean empty) {
      // Required to ensure that cell displays properly
      super.updateItem(item, empty);

      if (empty || item == null) {
         setGraphic(null); // Don't display anything
      }
      else {
         // Set ImageView's thumbnail image
         thumbImageView.setImage(new Image(item.getThumbImage()));
         label.setText(item.getTitle()); // Configure Label's text
         setGraphic(vbox); // Attach custom layout to ListView cell
      }
   }
}