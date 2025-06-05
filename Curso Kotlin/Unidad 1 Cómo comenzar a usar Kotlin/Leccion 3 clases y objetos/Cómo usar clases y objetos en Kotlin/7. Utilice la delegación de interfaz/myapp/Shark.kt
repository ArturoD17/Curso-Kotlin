package example.myapp

object GreyColor : FishColor {
    override val color = "grey"
}

class Shark(
    fishColor: FishColor = GreyColor
) : FishAction by PrintingFishAction("hunt and eat fish"),
    FishColor by fishColor
