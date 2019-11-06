//package clicker.view
//
//import io.socket.client.{IO, Socket}
//import io.socket.emitter.Emitter
//import javafx.application.Platform
//import scalafx.application.JFXApp
//import scalafx.application.JFXApp.PrimaryStage
//import scalafx.scene.Scene
//import scalafx.scene.control.{Button, TextField}
//import play.api.libs.json.{JsValue, Json}
//import javafx.event.{ActionEvent, EventHandler}
//import scalafx.scene.control.TextField
//import scalafx.scene.layout.VBox
//import scalafx.scene.paint.Color
//import scalafx.scene.shape.Circle
//
//
//class HandleMessagesFromServer extends Emitter.Listener {
//  override def call(objects: Object*): Unit = {
//
//    // Use runLater when interacting with the GUI
//    Platform.runLater(() => {
//      // This method is called whenever a new game state is received from the server
//      val jsonGameState = objects.apply(0).toString
//
//      println(jsonGameState)
//
//      val parsed: JsValue = Json.parse(jsonGameState)
//
//      //      {
//      //        "username": "test",
//      //        "gold": 0,
//      //        "lastUpdateTime": 51219191695809355,
//      //        "equipment": {
//      //          "shovel": {"id": "shovel", "name": "Shovel", "numberOwned": 0, "cost": 10},
//      //          "excavator": {"id": "excavator", "name": "Excavator", "numberOwned": 0, "cost": 200},
//      //          "mine": {"id": "mine", "name": "Gold Mine", "numberOwned": 0, "cost": 1000}
//      //        }
//      //      }
//
//      val gold: Double = (parsed\ "gold").as[Double]  // current gold
//      val numberOwned: Double = (parsed\ "equipment" \ "mine" \ "numberOwned").as[Double] // Number Owned
//      val shovelOwned: Double = (parsed\ "equipment" \ "shovel" \ "numberOwned").as[Double] // Number Owned
//      val excavatorOwnded: Double = (parsed \"equipment" \ "excavator" \ "numberOwned").as[Double] // Number Owned
//      val shovelCost: Double = (parsed \"equipment" \ "shovel" \ "cost").as[Double]
//      val excavatorCost: Double = (parsed \"equipment" \ "excavator" \ "cost").as[Double]
//      val mineCost: Double = (parsed \"equipment" \ "mine" \ "cost").as[Double]
//
//      DesktopGUI.outputDisplay.text = gold.toString          // need to connect this to the box
//      DesktopGUI.Excavator_Button.text = excavatorCost.toString
//      DesktopGUI.Shovel_Button.text = shovelCost.toString
//      DesktopGUI.Mine_Button.text = mineCost.toString
//
//
//      //      DesktopGUI.outputDisplay.text = numberOwned.toString
//      //      DesktopGUI.outputDisplay.text = shovelOwned.toString
//      //      DesktopGUI.outputDisplay.text = excavatorOwnded.toString
//
//
//      // TODO: Display the game state on your GUI
//      // You must display: current gold, and the name, number owned, and cost for each type of equipment
//
//      // You can access any variables/methods in the DesktopGUI object from this class
//      // ex. DesktopGUI.goldTextField.text = goldFromGameState
//
//    })
//  }
//}
//
//
//object DesktopGUI extends JFXApp {
//
//  var socket: Socket = IO.socket("https://tictactoe.info/")
//  socket.on("gameState", new HandleMessagesFromServer)
//  socket.connect()
//
//  // Change "test" to any username you'd like to start a new game
//  socket.emit("register", "John Wick3")
//
//  // Call this method whenever the user clicks your gold button
//  def clickGold(): Unit = {
//    socket.emit("clickGold")
//  }
//
//  // Call this method whenever the user clicks to purchase equipment
//  // The parameter is the id of the equipment type to purchase
//  def buyEquipment(equipmentId: String): Unit = {
//    socket.emit("buy", equipmentId)
//  }
//
//  val outputDisplay: TextField = new TextField {
//    editable = false
//    style = "-fx-font: 15 ariel;"
//  }
//
//  val Gold_Button: Button = new Button {
//    minWidth = 200
//    minHeight = 200
//    style = "-fx-font: 28 ariel;"
//    text = "gold"
//    onAction = new Gold(outputDisplay)
//  }
//
//  val Shovel_Button: Button = new Button {
//    minWidth = 200
//    minHeight = 200
//    style = "-fx-font: 28 ariel;"
//    text = "gold"
//    onAction = new Shovel(outputDisplay)
//  }
//
//  val Excavator_Button: Button = new Button {
//    minWidth = 200
//    minHeight = 200
//    style = "-fx-font: 28 ariel;"
//    onAction = new Excavator(outputDisplay)
//  }
//
//  val Mine_Button: Button = new Button {
//    minWidth = 200
//    minHeight = 200
//    style = "-fx-font: 28 ariel;"
//    onAction = new Mine(outputDisplay)
//  }
//
//  val verticalBox: VBox = new VBox() {
//    children = List(Gold_Button, Shovel_Button, Excavator_Button, Mine_Button, outputDisplay)
//  }
//
//  this.stage = new PrimaryStage {
//    scene = new Scene() {
//      content = List(verticalBox)
//
//    }
//  }
//
//  // TODO: Setup your GUI
//  // You may create and place all GUI elements (TextFields, Buttons, etc) then only change the text on
//  // each element when a new game state is received
//  // You may assume that there will be exactly 3 types of equipment with ids of "shovel", "excavator", and "mine"
//
//  class Gold(outputDisplay: TextField) extends EventHandler[ActionEvent] {
//    override def handle(event: ActionEvent): Unit = {
//      DesktopGUI.clickGold()
//    }
//  }
//
//  class Shovel(outputDisplay: TextField) extends EventHandler[ActionEvent] {
//
//    override def handle(event: ActionEvent): Unit = {
//      DesktopGUI.buyEquipment("shovel")  // Don't know why this is working..
//    }
//  }
//
//  class Excavator(outputDisplay: TextField) extends EventHandler[ActionEvent] {
//    override def handle(event: ActionEvent): Unit = {
//      DesktopGUI.buyEquipment("excavator")
//    }
//  }
//
//  class Mine(outputDisplay: TextField) extends EventHandler[ActionEvent] {
//    override def handle(event: ActionEvent): Unit = {
//      DesktopGUI.buyEquipment("mine")
//    }
//
//  }
//
//}