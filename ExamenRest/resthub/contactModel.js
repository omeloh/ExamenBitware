// contactModel.js
var mongoose = require('mongoose');
const AutoIncrement = require('mongoose-sequence')(mongoose);
// Configuracion esquema
var contactSchema = mongoose.Schema({
	_id: Number,
	Cliente_ID: {
		type: Number
	},
	Nombre_Usuario: {
        type: String,
        required: true
    },
	Contrasena: {
        type: String,
        required: true
    },
    Nombre: {
        type: String,
        required: true
    },
    Apellidos: {
        type: String,
        required: true
    },
    Correo_Electronico: {
        type: String,
        required: true
    },
	Edad: {
		type: Number
	},
	Estatura: {
		type: Number
	},
	Peso: {
		type: Number
	},
	IMC: {
		type: Number
	},
	GEB: {
		type: Number
	},
	ETA: {
		type: Number
	},
    Fecha_Creacion: {
        type: Date,
        default: Date.now
    },
	Fecha_Actualizacion: {
        type: Date
    }
},{ _id:false });
contactSchema.plugin(AutoIncrement);

var Contact = module.exports = mongoose.model('contact', contactSchema);
module.exports.get = function (callback, limit) {
    Contact.find(callback).limit(limit);
}