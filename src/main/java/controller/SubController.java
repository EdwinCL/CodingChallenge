package controller;

import javafx.scene.control.ListView;

/**
 * Base class for child controllers
 */
public class SubController {

    protected CodingChallengeController parentController;

    protected ListView<String> outputListView;

    /**
     *
     * @param parentController
     */
    public void setParentController(CodingChallengeController parentController) {
        this.parentController = parentController;
    } // end method setParentController

    /**
     *
     * @param outputListView
     */
    public void setOutputListView(ListView<String> outputListView) {
        this.outputListView = outputListView;
    } // end method setOutputListView

} // end class SubController
