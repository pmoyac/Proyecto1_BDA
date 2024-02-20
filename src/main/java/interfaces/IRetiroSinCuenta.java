
package interfaces;

import objetos.RetiroSinCuenta;

/**
 *
 * @author Pedro Moya, Adriana Gutiérrez
 */
public interface IRetiroSinCuenta {
    public RetiroSinCuenta guardar(RetiroSinCuenta retiroSinCuenta);
    public RetiroSinCuenta PorFolioContra(RetiroSinCuenta retiroSinCuenta);
    public void ProcedimientoRetirar(RetiroSinCuenta retiroSinCuenta);
}
