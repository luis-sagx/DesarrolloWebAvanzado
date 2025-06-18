from zeep import Client
from datetime import datetime, date, time
import sys

WSDL_URL = "http://localhost:8081/ws/hoteles?wsdl"

try:
    client = Client(wsdl=WSDL_URL)
except Exception as e:
    print("Error al conectar con el servicio SOAP:", e)
    sys.exit(1)

def menu():
    while True:
        print("\n=== CLIENTE SOAP: GESTIÓN DE HOTELES ===")
        print("1. Listar hoteles")
        print("2. Insertar nuevo hotel")
        print("3. Salir")

        choice = input("Seleccione una opción (1-3): ").strip()

        if choice == "1":
            listar_hoteles()
        elif choice == "2":
            insertar_hotel()
        elif choice == "3":
            print("Cerrando ")
            break
        else:
            print("Opción no válida. Intente nuevamente.")

def listar_hoteles():
    try:
        hoteles = client.service.listarHoteles()
        if not hoteles:
            print("No hay hoteles registrados.")
            return
        print("\nLista de hoteles:")
        for h in hoteles:
            print(f"{h.nombre} | {h.categoria} | Habitaciones: {h.totalHabitaciones} | Avalúo: ${h.avaluo} | Fecha: {h.fecha}")
    except Exception as e:
        print("Error al listar hoteles:", e)

def insertar_hotel():
    try:
        nombre = input("Nombre del hotel: ").strip()
        categoria = input("Categoría: ").strip()
        total_habitaciones = int(input("Total de habitaciones: ").strip())
        avaluo = float(input("Avalúo en dólares: ").strip())
        fecha_str = input("Fecha (yyyy-MM-dd): ").strip()
        hora_str = input("Hora (HH:mm): ").strip()

        try:
            fecha = datetime.strptime(fecha_str, "%Y-%m-%d").date()
            hora = datetime.strptime(hora_str, "%H:%M").time()
        except ValueError:
            print("Formato incorrecto en fecha u hora. Usa yyyy-MM-dd y HH:mm.")
            return

        success = client.service.insertarHotel(nombre, categoria, total_habitaciones, avaluo, fecha, hora)
        if success:
            print("Hotel insertado correctamente.")
        else:
            print("No se pudo insertar el hotel.")
    except Exception as e:
        print("Error al insertar hotel:", e)

if __name__ == "__main__":
    menu()
