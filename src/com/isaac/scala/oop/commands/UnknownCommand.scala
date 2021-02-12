package com.isaac.scala.oop.commands

import com.isaac.scala.oop.filesystem.State

class UnknownCommand extends Command {

  override def apply(state: State): State =
    state.setMessage("Command not found!")
}
