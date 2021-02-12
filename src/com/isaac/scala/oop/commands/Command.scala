package com.isaac.scala.oop.commands

import com.isaac.scala.oop.filesystem.State

trait Command {

  def apply(state: State): State
}
