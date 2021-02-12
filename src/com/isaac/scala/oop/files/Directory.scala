package com.isaac.scala.oop.files

class Directory(override val parentPath: String, override val name: String)
  extends DirEntry(parentPath, name) {

}

object Directory{
  val SEPARATOR = "/"
  val ROOT_PATH = "/"

  def ROOT: Directory = this.empty("", "")

  def empty(parentPath: String, name: String): Directory =
    new Directory(parentPath, name)
}
