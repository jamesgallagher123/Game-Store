package pages

import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.paint.Color._
import scalafx.scene.shape.Rectangle

/**
  * Created by Administrator on 21/06/2017.
  */
object Template extends JFXApp {
  stage = new JFXApp.PrimaryStage {
    title.value = "Hello Stage"
    width = 800
    height = 600
    scene = new Scene {
      fill = LightGray
      content = new Rectangle {
        x = 25
        y = 40
        width = 100
        height = 100
        fill <== when(hover) choose Green otherwise Red
      }
    }
  }
}
