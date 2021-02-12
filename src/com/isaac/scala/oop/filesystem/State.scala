package com.isaac.scala.oop.filesystem

import com.isaac.scala.oop.files.Directory

class State(val root: Directory, val wd: Directory, val output: String){

  def show: Unit =
    print(State.SHELL_TOKEN)

  def setMessage(message: String): State =
    new State(root, wd, message)
}

object State {
  val SHELL_TOKEN = "$ "

  def apply(root: Directory, wd: Directory, output: String = "") =
    new State(root, wd, output)
}
