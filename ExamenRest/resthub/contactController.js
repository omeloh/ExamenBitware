// contactController.js
// Import contact model
Contact = require('./contactModel');

exports.index = function (req, res) {
    Contact.get(function (err, contacts) {
        if (err) {
            res.json({
                Cve_Error: '-1',
				Cve_Mensaje: 'Error al consultar contactos: '+err,
            });
        }
        res.json({
            Cve_Error: '0',
            Cve_Mensaje: 'Consulta de contactos',
            data: contacts
        });
    });
};
// Crear contacto
exports.new = function (req, res) {
    var contact = new Contact();
    contact.Nombre_Usuario = req.body.Nombre_Usuario ? req.body.Nombre_Usuario : contact.Nombre_Usuario;
    contact.Contrasena = req.body.Contrasena;
    contact.Nombre = req.body.Nombre;
    contact.Apellidos = req.body.Apellidos;
	contact.Correo_Electronico = req.body.Correo_Electronico;
    contact.save(function (err) {
         if (err)
             res.json({
                Cve_Error: '-1',
				Cve_Mensaje: 'Error al agregar el contacto: '+err,
            });
			res.json({
            Cve_Error: '0',
            Cve_Mensaje: 'Contacto Agregado Correctamente',
            data: contact
        });
    });
};
// Ver informacion de contacto
exports.view = function (req, res) {
    Contact.findById(req.params.contact_id, function (err, contact) {
        if (err)
            res.json({
                Cve_Error: '-1',
				Cve_Mensaje: 'Error al consultar el contacto: '+err,
				});
        res.json({
            Cve_Error: '0',
            Cve_Mensaje: 'Contacto Encontrado',
            data: contact
        });
    });
};
// Actualizar contacto
exports.update = function (req, res) {
Contact.findById(req.params.contact_id, function (err, contact) {
        if (err)
            res.send(err);
contact.Edad = req.body.Edad ? req.body.Edad : contact.Edad;
        contact.Estatura = req.body.Estatura;
        contact.Peso = req.body.Peso;
        contact.GEB = req.body.GEB;
        contact.save(function (err) {
            if (err)
                res.json({
                Cve_Error: '-1',
				Cve_Mensaje: 'Error al actualizar el contacto: '+err,
				});
            res.json({
				Cve_Error: '0',
                Cve_Mensaje: 'Contacto Actualizado',
                data: contact
            });
        });
    });
};
// Borrar contacto
exports.delete = function (req, res) {
    Contact.remove({
        _id: req.params.contact_id
    }, function (err, contact) {
        if (err)
            res.json({
                Cve_Error: '-1',
				Cve_Mensaje: 'Error al eliminar el contacto: '+err,
				});
res.json({
            status: "success",
            Cve_Error: '0',
            Cve_Mensaje: 'Contacto Eliminado Correctamente',
        });
    });
};