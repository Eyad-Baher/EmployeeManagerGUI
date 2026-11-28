/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DepartmentBackend.Exceptions;

/**
 *
 * @author Lina Islam
 */
public class DepartmentInUseException extends RuntimeException {

    public DepartmentInUseException(String message) {
        super(message);
    }
}
