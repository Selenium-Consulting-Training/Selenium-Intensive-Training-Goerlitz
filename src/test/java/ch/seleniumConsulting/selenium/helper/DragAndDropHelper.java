package ch.seleniumConsulting.selenium.helper;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DragAndDropHelper
{

    /*

                K     K   E E E E    Y     Y   ||                             ||
                K   K     E           Y   Y    ||                             ||
                K K       E            Y Y     ||                             ||
                K         E E E E       Y      ||!BIG2UKubczzuFHrU9OqPsym3Oxg!||
                K K       E             Y      ||                             ||
                K   K     E             Y
                K     K   E E E E       Y      ||                             ||


    */

    private static String javaScriptEventSimulator = "" +
            /* Creates DragAndDropHelper drag event */
            "function createDragEvent(eventName, options)\r\n" +
            "{\r\n" +
            "var event = document.createEvent('HTMLEvents');\r\n" +
            "event.initEvent('DragEvent', true, true);\r\n" +
            "   var screenX = window.screenX + options.clientX;\r\n" +
            "   var screenY = window.screenY + options.clientY;\r\n" +
            "   var clientX = options.clientX;\r\n" +
            "   var clientY = options.clientY;\r\n" +
            "   var dataTransfer = {\r\n" +
            "       data: options.dragData == null ? {} : options.dragData,\r\n" +
            "       setData: function(eventName, val){\r\n" +
            "           if (typeof val === 'string') {\r\n" +
            "               this.data[eventName] = val;\r\n" +
            "           }\r\n" +
            "       },\r\n" +
            "       getData: function(eventName){\r\n" +
            "           return this.data[eventName];\r\n" +
            "       },\r\n" +
            "       clearData: function(){\r\n" +
            "           return this.data = {};\r\n" +
            "       },\r\n" +
            "       setDragImage: function(dragElement, x, y) {}\r\n" +
            "   };\r\n" +
            "   var eventInitialized=false;\r\n" +
            "   if (event != null && event.initDragEvent) {\r\n" +
            "       try {\r\n" +
            "           event.initDragEvent(eventName, true, true, window, 0, screenX, screenY, clientX, clientY, false, false, false, false, 0, null, dataTransfer);\r\n" +
            "           event.initialized=true;\r\n" +
            "       } catch(err) {\r\n" +
            "           // no-op\r\n" +
            "       }\r\n" +
            "   }\r\n" +
            "   if (!eventInitialized) {\r\n" +
            "       event = document.createEvent(\"CustomEvent\");\r\n" +
            "       event.initCustomEvent(eventName, true, true, null);\r\n" +
            "       event.view = window;\r\n" +
            "       event.detail = 0;\r\n" +
            "       event.screenX = screenX;\r\n" +
            "       event.screenY = screenY;\r\n" +
            "       event.clientX = clientX;\r\n" +
            "       event.clientY = clientY;\r\n" +
            "       event.ctrlKey = false;\r\n" +
            "       event.altKey = false;\r\n" +
            "       event.shiftKey = false;\r\n" +
            "       event.metaKey = false;\r\n" +
            "       event.button = 0;\r\n" +
            "       event.relatedTarget = null;\r\n" +
            "       event.dataTransfer = dataTransfer;\r\n" +
            "   }\r\n" +
            "   return event;\r\n" +
            "}\r\n" +

            /* Creates DragAndDropHelper mouse event */
            "function createMouseEvent(eventName, options)\r\n" +
            "{\r\n" +
            "   var event = document.createEvent(\"MouseEvent\");\r\n" +
            "   var screenX = window.screenX + options.clientX;\r\n" +
            "   var screenY = window.screenY + options.clientY;\r\n" +
            "   var clientX = options.clientX;\r\n" +
            "   var clientY = options.clientY;\r\n" +
            "   if (event != null && event.initMouseEvent) {\r\n" +
            "       event.initMouseEvent(eventName, true, true, window, 0, screenX, screenY, clientX, clientY, false, false, false, false, 0, null);\r\n" +
            "   } else {\r\n" +
            "       event = document.createEvent(\"CustomEvent\");\r\n" +
            "       event.initCustomEvent(eventName, true, true, null);\r\n" +
            "       event.view = window;\r\n" +
            "       event.detail = 0;\r\n" +
            "       event.screenX = screenX;\r\n" +
            "       event.screenY = screenY;\r\n" +
            "       event.clientX = clientX;\r\n" +
            "       event.clientY = clientY;\r\n" +
            "       event.ctrlKey = false;\r\n" +
            "       event.altKey = false;\r\n" +
            "       event.shiftKey = false;\r\n" +
            "       event.metaKey = false;\r\n" +
            "       event.button = 0;\r\n" +
            "       event.relatedTarget = null;\r\n" +
            "   }\r\n" +
            "   return event;\r\n" +
            "}\r\n" +

            /* Runs the events */
            "function dispatchEvent(webElement, eventName, event)\r\n" +
            "{\r\n" +
            "   if (webElement.dispatchEvent) {\r\n" +
            "       webElement.dispatchEvent(event);\r\n" +
            "   } else if (webElement.fireEvent) {\r\n" +
            "       webElement.fireEvent(\"on\"+eventName, event);\r\n" +
            "   }\r\n" +
            "}\r\n" +

            /* Simulates an individual event */
            "function simulateEventCall(element, eventName, dragStartEvent, options) {\r\n" +
            "   var event = null;\r\n" +
            "   if (eventName.indexOf(\"mouse\") > -1) {\r\n" +
            "       event = createMouseEvent(eventName, options);\r\n" +
            "   } else {\r\n" +
            "       event = createDragEvent(eventName, options);\r\n" +
            "   }\r\n" +
            "   if (dragStartEvent != null) {\r\n" +
            "       event.dataTransfer = dragStartEvent.dataTransfer;\r\n" +
            "   }\r\n" +
            "   dispatchEvent(element, eventName, event);\r\n" +
            "   return event;\r\n" +
            "}\r\n";


    /**
     * Simulates drag and drop
     */
    private static String simulateHTML5DragAndDrop = javaScriptEventSimulator +
            "function simulateHTML5DragAndDrop(dragFrom, dragTo, dragFromX, dragFromY, dragToX, dragToY) {\r\n" +
            "   var mouseDownEvent = simulateEventCall(dragFrom, \"mousedown\", null, {clientX: dragFromX, clientY: dragFromY});\r\n" +
            "   var dragStartEvent = simulateEventCall(dragFrom, \"dragstart\", null, {clientX: dragFromX, clientY: dragFromY});\r\n" +
            "   var dragEnterEvent = simulateEventCall(dragTo,   \"dragenter\", dragStartEvent, {clientX: dragToX, clientY: dragToY});\r\n" +
            "   var dragOverEvent  = simulateEventCall(dragTo,   \"dragover\",  dragStartEvent, {clientX: dragToX, clientY: dragToY});\r\n" +
            "   var dropEvent      = simulateEventCall(dragTo,   \"drop\",      dragStartEvent, {clientX: dragToX, clientY: dragToY});\r\n" +
            "   var dragEndEvent   = simulateEventCall(dragFrom, \"dragend\",   dragStartEvent, {clientX: dragToX, clientY: dragToY});\r\n" +
            "}\r\n" +
            "simulateHTML5DragAndDrop(arguments[0], arguments[1], arguments[2], arguments[3], arguments[4], arguments[5]);\r\n";



    /**
     * Drags and drops DragAndDropHelper web element from source to target
     *
     * @param driver
     *            The WebDriver to execute on
     * @param dragFrom
     *            The WebElement to drag from
     * @param dragTo
     *            The WebElement to drag to
     * @param dragFromX
     *            The position to click relative to the top-left-corner of the
     *            client
     * @param dragFromY
     *            The position to click relative to the top-left-corner of the
     *            client
     * @param dragToX
     *            The position to release relative to the top-left-corner of the
     *            client
     * @param dragToY
     *            The position to release relative to the top-left-corner of the
     *            client
     */
    public static void dragAndDrop(WebDriver driver, WebElement dragFrom, WebElement dragTo, int dragFromX, int dragFromY, int dragToX, int dragToY)
    {
        ((JavascriptExecutor)driver).executeScript(simulateHTML5DragAndDrop, dragFrom, dragTo, dragFromX, dragFromY, dragToX, dragToY);
    }

    /**
     * Drags and drops DragAndDropHelper web element from source to target
     *
     * @param driver
     *            The WebDriver to execute on
     * @param dragFrom
     *            The WebElement to drag from
     * @param dragTo
     *            The WebElement to drag to
     * @param dragFromPosition
     *            The place to click on the dragFrom
     * @param dragToPosition
     *            The place to release on the dragTo
     */
    public static void dragAndDrop(WebDriver driver, WebElement dragFrom, WebElement dragTo)
    {
        Point fromLocation = dragFrom.getLocation();
        Point toLocation = dragTo.getLocation();

        // Get Client X and Client Y locations
        int dragFromX = fromLocation.getX();
        int dragFromY = fromLocation.getY();
        int dragToX = toLocation.getX();
        int dragToY = toLocation.getY();

        dragAndDrop(driver, dragFrom, dragTo, dragFromX, dragFromY, dragToX, dragToY);
    }



}
