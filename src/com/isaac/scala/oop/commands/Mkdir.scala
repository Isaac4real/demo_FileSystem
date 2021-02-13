package com.isaac.scala.oop.commands
import com.isaac.scala.oop.files.{DirEntry, Directory}
import com.isaac.scala.oop.filesystem.State

class Mkdir(name: String) extends CreateEntry(name) {

  override def createSpecificEntry(state: State): DirEntry =
    Directory.empty(state.wd.path, name)
}
